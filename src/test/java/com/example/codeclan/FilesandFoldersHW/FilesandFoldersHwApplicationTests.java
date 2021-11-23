package com.example.codeclan.FilesandFoldersHW;

import com.example.codeclan.FilesandFoldersHW.models.File;
import com.example.codeclan.FilesandFoldersHW.models.Folder;
import com.example.codeclan.FilesandFoldersHW.models.User;
import com.example.codeclan.FilesandFoldersHW.repositiories.FileRepository;
import com.example.codeclan.FilesandFoldersHW.repositiories.FolderRepository;
import com.example.codeclan.FilesandFoldersHW.repositiories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class FilesandFoldersHwApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void createUserAndFolderThenSave(){
		User james = new User("James");
		userRepository.save(james);
		Folder folder1 = new Folder("Folder1", james);
		folderRepository.save(folder1);
		File file1 = new File("File1", ".jpg", 10, folder1 );
		fileRepository.save(file1);

		folder1.addFile(file1);
		james.addFolder(folder1);

	}




}
