/******************************************************************************
 * Space Shooter Software License
 * Version 0.0.2-alpha
 *
 * Copyright (C) 2015 Last Stand Studio
 *
 *  SpaceShooter is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SpaceShooter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with SpaceShooter.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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

	/**
	 *
	 * @param name
	 * @param version
	 * @param type
	 * @param classpath
	 * @param description
	 * @param reqversion
	 * @param reviseddate
	 * @param authors
	 */
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

    /**
     * @return name
     */
	public String getName() {
		return name;
	}

    /**
     * @return type
     */
	public String getType() {
		return type;
	}

    /**
     * @return version
     */
	public String getVersion() {
		return version;
	}

    /**
     * @return classpath
     */
	public String getClasspath() {
		return classpath;
	}

    /**
     * @return description
     */
	public String[] getDescription() {
		return description;
	}

    /**
     * @return required verison
     */
	public String getReqVersion() {
		return reqVersion;
	}

    /**
     * @return reviesed date
     */
	public Date getRevisedDate() {
		return revisedDate;
	}

    /**
     * @return authors
     */
	public String[] getAuthors() {
		return authors;
	}

}
