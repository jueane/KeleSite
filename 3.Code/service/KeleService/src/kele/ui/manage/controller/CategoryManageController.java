package kele.ui.manage.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kele.entity.Category;
import kele.service.CategoryService;
import kele.ui.manage.viewmodel.CategoryVm;
import kele.util.JsonHelper;
import kele.util.Pager;

@Controller
@RequestMapping("manage/category")
public class CategoryManageController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping
	public String index(ModelMap modelMap, HttpSession session, int... page) {
		Pager pager = new Pager();
		if (page != null && page[0] > 1) {
			pager.setPageIndex(page[0]);
		}

		categoryService.getPagedList(pager);
		modelMap.addAttribute("pager", pager);

		return "manage/freemarker/category/Index";
	}

	@RequestMapping("list")
	@ResponseBody
	public byte[] list(HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=UTF-8");
		Pager pager = new Pager();
		pager.setPageSize(Integer.MAX_VALUE);
		categoryService.getPagedList(pager);
		List<Object> categoryList = pager.getList();
		List<CategoryVm> categoryVmList = new ArrayList<>();

		for (int i = 0; categoryList != null && i < categoryList.size(); i++) {
			Category category = (Category) categoryList.get(i);
			CategoryVm cVm = new CategoryVm();
			cVm.id = category.getId();
			cVm.parentId = category.getParentId();
			cVm.name =category.getDisplay();
			categoryVmList.add(cVm);
		}
		return JsonHelper.toJson(categoryVmList);
	}

	@RequestMapping(value="create",method=RequestMethod.POST)
	@ResponseBody
	public String create(int id, String text) {
		Category category = new Category();
		category.setParentId(id);
		category.setDisplay(text);
		categoryService.insert(category);
		return String.valueOf(category.getId());
	}

	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(int id, String text) {
		Category category = categoryService.getById(id);
		category.setDisplay(text);
		categoryService.update(category);
		return "true";
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(int id) {
		Category category = categoryService.getById(id);
		category.setDeleted(true);
		categoryService.update(category);
		return "true";
	}
}
