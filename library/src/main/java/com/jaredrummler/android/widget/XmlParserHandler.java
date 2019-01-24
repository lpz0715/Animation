package com.jaredrummler.android.widget;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XmlParserHandler extends DefaultHandler {

	/**
	 * 存储所有的解析对象
	 */
	private List<PathModel> provinceList = new ArrayList<PathModel>();

	public XmlParserHandler() {

	}

	public List<PathModel> getDataList() {
		return provinceList;
	}

	@Override
	public void startDocument() throws SAXException {
		// 当读到第一个开始标签的时候，会触发这个方法
	}

	PathModel PathModel = new PathModel();

	@Override
	public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
		// 当遇到开始标记的时候，调用这个方法
		if (qName.equals("path")) {
			PathModel = new PathModel();
			PathModel.setPath(attributes.getValue("d"));
			PathModel.setColor(attributes.getValue("fill"));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// 遇到结束标记的时候，会调用这个方法
		if (qName.equals("path")) {
			provinceList.add(PathModel);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
	}

}
