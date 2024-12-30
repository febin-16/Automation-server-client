package com.pelatro.automation.gui.backend.thirdpartysite.testcase.step;

import com.pelatro.automation.gui.backend.thirdpartysite.utils.ConnectRemoteServer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ServerSteps {
	
	@Given("I created a directory (.*) in my home directory")
	public void createDirectory(String dirName) {
		new ConnectRemoteServer().execute("mkdir /home/pelatro/" + dirName);
		String ls = new ConnectRemoteServer().execute("ls /home/pelatro");
		if (!ls.contains(dirName))
			throw new AssertionError("Directory creation is failed !!!");
	}
	
	@And("I create (.*) files with (.*) lines each in (.*)") 
	public void createFilesAndInsertLines(String numFiles, String numLines, String dirname) {
	    ConnectRemoteServer server = new ConnectRemoteServer(); 
	    server.execute("cd /home/pelatro/" + dirname);
	    for (int i = 1; i <=Integer.parseInt(numFiles); i++) {
	        server.execute("touch /home/pelatro/"+dirname+"/file_" + i + ".txt");
	        String content="";
	        for (int j = 1; j <= Integer.parseInt(numLines); j++) {
	            content="line number"+j+"\n";
		        server.execute(String.format("echo '%s' >> /home/pelatro/"+dirname+"/file_%d.txt", content, i));
	        }
	    }
	}
	
	@Then("I list all the files in (.*)")
	public void i_list_all_the_files_in_test(String dirName) {
		String ls = new ConnectRemoteServer().execute("ls /home/pelatro/"+dirName+"/" );
		if (ls.isEmpty())
			throw new AssertionError("No files present");
	}
 
	@Then("I should append the contents of the files to (.*) file in (.*) directory")
	public void i_should_append_the_contents_of_the_files_to_temp_file(String fileName,String dirname) {
		int i=1;
		while(i<=5) {
			new ConnectRemoteServer().execute("cat /home/pelatro/"+dirname+"/file_"+i+".txt >> "+"/home/pelatro/"+dirname+"/"+fileName);
			i++;
		}
	}
 
	@Then("I download the (.*) file")
	public void i_download_the_temp_file(String fileName) {
		new ConnectRemoteServer().download("/home/pelatro/Downloads","/home/pelatro/test/"+fileName);
		if(!new ConnectRemoteServer().execute("ls /home/pelatro/Downloads/").contains(fileName))
			throw new AssertionError("Downloaded file not present");
	}
 
	@Then("I print the contents in the (.*) file")
	public void i_print_the_contents_in_the_temp_file(String fileName) {
		new ConnectRemoteServer().execute("cat /home/pelatro/Downloads/"+fileName);

 
	}
	


}

