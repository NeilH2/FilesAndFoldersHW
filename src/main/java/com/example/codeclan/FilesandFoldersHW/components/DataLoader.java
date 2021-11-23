package com.example.codeclan.FilesandFoldersHW.components;

import com.example.codeclan.FilesandFoldersHW.models.File;
import com.example.codeclan.FilesandFoldersHW.models.Folder;
import com.example.codeclan.FilesandFoldersHW.models.User;
import com.example.codeclan.FilesandFoldersHW.repositiories.FileRepository;
import com.example.codeclan.FilesandFoldersHW.repositiories.FolderRepository;
import com.example.codeclan.FilesandFoldersHW.repositiories.UserRepository;
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
        User james = new User("James");
        userRepository.save(james);
        Folder folder1 = new Folder("Folder1", james);
        folderRepository.save(folder1);
        File file1 = new File("File1", ".jpg", 10, folder1 );
        fileRepository.save(file1);
        folder1.addFile(file1);
        folderRepository.save(folder1);
        james.addFolder(folder1);
        userRepository.save(james);

    }


}
