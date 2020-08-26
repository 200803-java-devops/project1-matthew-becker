package net.robotap.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class BashCommands {
    public String gitClone(String httpUrl) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        new File("clients").mkdir();

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("bash", "-c", "git clone " + httpUrl);
        pb.directory(new File(System.getProperty("user.dir") + "/clients"));
        try {
            Process process = pb.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return output.toString();
            } else {
                return "failure, client already cloned";
            }
        } catch (IOException e) {
            System.err.println("error running clone command: " + e);
        } catch (InterruptedException e) {
            System.err.println("error running clone command: " + e);
        }
        return "failed";
    }
}