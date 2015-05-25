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

package com.laststandstudio.space.launcher;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpdateAndStartThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println(Util.getInstallDir());
            System.out.println(new File(Util.getInstallDir() + File.separator + "LastStandStudio" + File.separator + "SpaceShooter").mkdirs());
            System.out.println("DIRECT MAKE");
            downloadFile("http://direct.mrblockplacer.net/ls/v0/vIndex.xml", Util.getInstallDir() + File.separator + "LastStandStudio" + File.separator + "SpaceShooter" + File.separator + "vIndex.xml");

            downloadReqFileds(parseIndexFile());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void downloadReqFileds(List<ReqFile> reqFiles) {
        for (ReqFile reqFile : reqFiles) {
            if (!new File(Util.getInstallDir() + File.separator + "LastStandStudio" + File.separator + "SpaceShooter" + File.separator + reqFile.getPath() + reqFile.getFileName()).exists()) {
                try {
                    downloadFile("http://direct.mrblockplacer.net/ls/v0/files/" + reqFile.getURL(), Util.getInstallDir() + File.separator + "LastStandStudio" + File.separator + "SpaceShooter" + File.separator + reqFile.getPath() + reqFile.getFileName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<ReqFile> parseIndexFile() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(new File(Util.getInstallDir() + File.separator + "LastStandStudio" + File.separator + "SpaceShooter" + File.separator + "vIndex.xml"));

            List<ReqFile> requiredFiles = new ArrayList<ReqFile>();
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String identifier = node.getAttributes().getNamedItem("ID").getNodeValue();
                    String name = element.getElementsByTagName("Name").item(0).getChildNodes().item(0).getNodeValue();
                    String version = element.getElementsByTagName("Version").item(0).getChildNodes().item(0).getNodeValue();
                    String type = element.getElementsByTagName("Type").item(0).getChildNodes().item(0).getNodeValue();
                    String path = element.getElementsByTagName("Path").item(0).getChildNodes().item(0).getNodeValue().replace(":>", File.separator);
                    String fileName = element.getElementsByTagName("FileName").item(0).getChildNodes().item(0).getNodeValue();
                    String url = element.getElementsByTagName("URL").item(0).getChildNodes().item(0).getNodeValue();
                    requiredFiles.add(new ReqFile(identifier, name, version, type, path, fileName, url));
                }
            }


            return requiredFiles;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void downloadFile(String urlString, String saveFileName) throws IOException {
        new File(saveFileName).getParentFile().mkdirs();
        System.out.println(saveFileName);
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
//            String fileName = "";
//            String disposition = httpURLConnection.getHeaderField("Content-Disposition");
//            String contentType = httpURLConnection.getContentType();
//            int contentLength = httpURLConnection.getContentLength();

//            if (disposition != null) {
//                int index = disposition.indexOf("filename=");
//                if (index > 0) {
//                    fileName = disposition.substring(index + 10, disposition.length() - 1);
//                }
//            } else {
//                fileName = urlString.substring(urlString.lastIndexOf("/") + 1, urlString.length());
//            }

//            System.out.println("Content-Type = " + contentType);
//            System.out.println("Content-Disposition = " + disposition);
//            System.out.println("Content-Length = " + contentLength);
//            System.out.println("FileName = " + fileName);

            InputStream inputStream = httpURLConnection.getInputStream();

            FileOutputStream fileOutputStream = new FileOutputStream(saveFileName);

            @SuppressWarnings("all")
            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            inputStream.close();
            System.out.println("File Downloaded: " + urlString);
        } else {
            System.out.println("Failed to download: " + urlString);
        }
        httpURLConnection.disconnect();
    }
}
