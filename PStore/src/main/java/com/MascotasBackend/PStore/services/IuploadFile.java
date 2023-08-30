package com.MascotasBackend.PStore.services;

import org.springframework.web.multipart.MultipartFile;


public interface IuploadFile {

    String managerFileUpload (MultipartFile file) throws Exception;




}
