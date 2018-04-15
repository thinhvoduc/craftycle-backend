/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categoryapp.resources.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author nhimbeobeo
 */
public interface FileManager {
    
    public String storageFilePath();
    
    public boolean isFileNameExisted(String fileName);
    
    public void writeFileToDisk(InputStream inputStream, String fileName, boolean forceWrite) throws IOException;
    
    public String getFileNameWithoutExtension(String fileName);
    
    public String getFileExtension(String fileName);
}
