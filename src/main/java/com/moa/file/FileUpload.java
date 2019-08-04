package com.moa.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.moa.message.PathMessage;

public class FileUpload {
	public static Map<String, Object> keepUpload(HttpServletRequest request) throws ServletException, IOException {
		System.out.println("FileUpload start");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		String encoding="utf-8";
		File currentDirPath = new File(PathMessage.IMG_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(3*1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<String> categoryList = null;
		List<String> productList = null;
		List<String> priceList = null;
		List<String> pictureList = null;
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(int i=0;i<items.size();i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) {
					if(fileItem.getFieldName().trim().equals("category")) {
						if(categoryList==null) {
							categoryList = new ArrayList<String>();
						}
						categoryList.add(fileItem.getString(encoding));
						continue;
					}
					if(fileItem.getFieldName().trim().equals("product_name")) {
						if(productList==null) {
							productList = new ArrayList<String>();
						}
						productList.add(fileItem.getString(encoding));
						continue;
					}
					if(fileItem.getFieldName().trim().equals("price")) {
						if(priceList==null) {
							priceList = new ArrayList<String>();
						}
						priceList.add(fileItem.getString(encoding));
						continue;
					}
					//System.out.println(fileItem.getFieldName()+"="+fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					if(fileItem.getSize()>0) {
						if(pictureList==null) {
							pictureList = new ArrayList<String>();
						}
						/*System.out.println("파라미터이름: "+fileItem.getFieldName());
						System.out.println("파일이름: "+fileItem.getName());
						System.out.println("파일크기: "+fileItem.getSize()+"bytes");*/
						pictureList.add(fileItem.getName());
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						File uploadFile = new File(currentDirPath+"\\"+fileName);
						fileItem.write(uploadFile);
					}
				}
			}
			if(categoryList!=null)
				articleMap.put("categoryList", categoryList);
			if(productList!=null)
				articleMap.put("productList", productList);
			if(priceList!=null)
				articleMap.put("priceList", priceList);
			if(pictureList!=null)
				articleMap.put("pictureList", pictureList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articleMap;
	}
	
	public static Map<String, Object> entrustUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> articleMap = new HashMap<String, Object>();
		String encoding="utf-8";
		File currentDirPath = new File(PathMessage.IMG_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(3*1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<String> categoryList = null;
		List<String> productList = null;
		List<String> productCntList = null;			//맡기는 물건 개수
		List<String> productSizeCntList = null;		//예상 크기별 개수
		List<String> dateList = null;		//picker
		List<String> priceList = null;		// 측정, 흥정 가격
		List<String> pictureList = null;		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(int i=0;i<items.size();i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) {
					if(fileItem.getFieldName().trim().equals("category")) {
						if(categoryList==null) {
							categoryList = new ArrayList<String>();
						}
						categoryList.add(fileItem.getString(encoding));
						continue;
					}
					if(fileItem.getFieldName().trim().equals("product_name")) {
						if(productList==null) {
							productList = new ArrayList<String>();
						}
						productList.add(fileItem.getString(encoding));
						continue;
					}
					if(fileItem.getFieldName().trim().equals("product_cnt")) {
						if(productCntList==null) {
							productCntList = new ArrayList<String>();
						}
						productCntList.add(fileItem.getString(encoding));
					}
					if(fileItem.getFieldName().trim().equals("product_size")) {
						if(productSizeCntList==null) {
							productSizeCntList = new ArrayList<String>();
						}
						productSizeCntList.add(fileItem.getString(encoding));
					}
					if(fileItem.getFieldName().trim().equals("date")) {
						if(dateList==null) {
							dateList = new ArrayList<String>();
						}
						dateList.add(fileItem.getString(encoding));
					}
					if(fileItem.getFieldName().trim().equals("price")) {
						if(priceList==null) {
							priceList = new ArrayList<String>();
						}
						priceList.add(fileItem.getString(encoding));
					}
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					if(fileItem.getSize()>0) {
						if(pictureList==null) {
							pictureList = new ArrayList<String>();
						}
						pictureList.add(fileItem.getName());
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						File uploadFile = new File(currentDirPath+"\\"+fileName);
						fileItem.write(uploadFile);
					}
				}
			}
			if(categoryList!=null)
				articleMap.put("categoryList", categoryList);
			if(productList!=null)
				articleMap.put("productList", productList);
			if(productCntList!=null)
				articleMap.put("productCntList", productCntList);
			if(productSizeCntList!=null)
				articleMap.put("productSizeCntList", productSizeCntList);
			if(priceList!=null)
				articleMap.put("priceList", priceList);
			if(dateList!=null)
				articleMap.put("dateList", dateList);
			if(pictureList!=null)
				articleMap.put("pictureList", pictureList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articleMap;
	}
}
