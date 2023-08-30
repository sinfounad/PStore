package com.MascotasBackend.PStore.services.Imp;

import org.springframework.web.multipart.MultipartFile;
import com.MascotasBackend.PStore.services.IuploadFile

import java.util.UUID;

public class uploadFilesSeviceImp implements IuploadFile{





    @Override
    public String managerFileUpload(MultipartFile file) throws Exception {

        try{

            String filename= UUID.randomUUID().toString();
            byte[] bytes= file.getBytes();
            String fileOriginalName = file.getOriginalFilename();
        }
        catch(Exception e){

          throw new Exception(e.getMessage());
        }
        return null;
    }
}
