package org.southriverhi.space.Addons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddonInfo {

	private String name = "";
	private String type = "";
	private String version = "";
	private String classpath = "";
	private String[] description;
	private String reqVersion = "";
	private Date revisedDate;
	private String[] authors;

	public AddonInfo(String name, String version, String type, String classpath, String description, String reqversion, String reviseddate, String authors) {
		this.name = name;
		this.version = version;
		this.type = type;
		this.classpath = classpath;
		this.description = description.split("\n");
		this.reqVersion = reqversion;
		try {
			this.revisedDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(reviseddate);
		} catch (ParseException e) {
		}
		this.authors = authors.split(",");
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public String getClasspath() {
		return classpath;
	}

	public String[] getDescription() {
		return description;
	}

	public String getReqVersion() {
		return reqVersion;
	}

	public Date getRevisedDate() {
		return revisedDate;
	}

	public String[] getAuthors() {
		return authors;
	}

}
