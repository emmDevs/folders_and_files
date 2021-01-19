package com.example.folderservice.components;

import com.example.folderservice.models.File;
import com.example.folderservice.models.Folder;
import com.example.folderservice.models.User;
import com.example.folderservice.repositories.FileRepository;
import com.example.folderservice.repositories.FolderRepository;
import com.example.folderservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){
    }
    public void run(ApplicationArguments args){
        User roosa = new User("Roosa");
        userRepository.save(roosa);
        Folder codeclan = new Folder("Codeclan Work", roosa);
        folderRepository.save(codeclan);
        Folder photos = new Folder("photos", roosa);
        folderRepository.save(photos);
        File homework = new File("homework", ".txt", codeclan);
        fileRepository.save(homework);
        File xmasJumper = new File("Xmas Jumper", ".jpg", photos);
        fileRepository.save(xmasJumper);
        File cv = new File("CV", ".txt", codeclan);
        fileRepository.save(cv);
        File halloween = new File("Halloween dress up", ".jpg", photos);
        fileRepository.save(halloween);
        codeclan.addFile(homework);
        codeclan.addFile(cv);
        photos.addFile(xmasJumper);
        photos.addFile(halloween);
        folderRepository.save(codeclan);
        folderRepository.save(photos);
        roosa.addFolder(codeclan);
        roosa.addFolder(photos);
        userRepository.save(roosa);
    }
}
