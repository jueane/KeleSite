package kele.ui.manage.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kele.util.JsonHelper;

@Controller
@RequestMapping("manage/upload")
public class UploadManageController {

	@RequestMapping
	@ResponseBody
	public byte[] uploadImage(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		//文件保存目录路径
		String savePath = request.getServletContext().getRealPath("/") + "attachment/";

		//文件保存目录URL
		String saveUrl  = request.getContextPath() + "/attachment/";
		
		//定义允许上传的文件扩展名
		HashMap <String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		//最大文件大小
		long maxSize = 10000000;

		//检查目录
		File uploadDir = new File(savePath);
		if(!uploadDir.isDirectory()){
			return getError("上传目录不存在。");
		}
		//检查目录写权限
		if(!uploadDir.canWrite()){
			return getError("上传目录没有写权限。");
		}
		
		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if(!extMap.containsKey(dirName)){
			return getError("目录名不正确。");
		}

		//创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		

		String fileName = file.getOriginalFilename();
		//检查文件大小
		if(file.getSize() > maxSize){
			return getError("上传文件大小超过限制。");
		}
		//检查扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		//if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
		if(new ArrayList<String>(extMap.values()).contains(fileExt)){
			return getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
		try{
			File uploadedFile = new File(savePath, newFileName);
			file.transferTo(uploadedFile);
		}catch(Exception e){
			return getError("上传文件失败。");
		}

		HashMap<String, Object> hashMap=new HashMap<>();
		hashMap.put("error", 0);
		hashMap.put("url", ymd+"/"+newFileName);
		return JsonHelper.toJson(hashMap);
	}
	private byte[] getError(String message) {
		HashMap<String, Object> hashMap=new HashMap<>();
		hashMap.put("error", 1);
		hashMap.put("message", message);
		return JsonHelper.toJson(hashMap);
		}

}
