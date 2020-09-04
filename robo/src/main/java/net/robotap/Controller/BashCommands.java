package net.robotap.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import net.robotap.model.BashResponse;


public class BashCommands {

    public BashResponse gitClone(String httpUrl) {
        return runBashCommand("/clients/", "git clone ", httpUrl);
    }

    public BashResponse runMavenInstall(String project) {
        return runBashCommand("/clients/" + project, "mvn clean install ", "");
    }

    public BashResponse getClientProjects() {
        return runBashCommand("/clients/", "ls ", "");
    }

    public BashResponse getHealth(String project) {
        return runBashCommand("/clients/", "mpstat ", "");
    }

    public BashResponse build(String project) {
        return runBashScript("/clients/", "start.sh ", project);
    }

    public BashResponse runBashCommand(String path, String command, String args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir") + path);

        new File("clients").mkdir();

        ProcessBuilder pb = new ProcessBuilder();
        System.out.println(command + args);
        pb.command("bash", "-c", command + args);
        pb.directory(new File(System.getProperty("user.dir") + path));
        try {
            Process process = pb.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            String error;
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
            int exitCode = process.waitFor();
            System.out.println("exitCode: " + exitCode);
            if (exitCode == 0) {
                return new BashResponse(output.toString(), "success: with command " + command, "1");
            } else {
                while ((error = err.readLine())!= null) {
                    output.append(error + "\n");
                }
                return new BashResponse(command, output.toString(), "0");
            }
        } catch (IOException e) {
            System.err.println("error running clone command: " + e);
        } catch (InterruptedException e) {
            System.err.println("error running clone command: " + e);
        }
        return new BashResponse(command, "failed: unknown error has occured", "0");
    }

    public BashResponse runBashScript(String path, String command, String args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir") + path);

        new File("clients").mkdir();

        ProcessBuilder pb = new ProcessBuilder();
        String fullpath = System.getProperty("user.dir") + path + command;
        System.out.println(fullpath + args);
        pb.command(command, args);
        pb.directory(new File(System.getProperty("user.dir") + path));
        try {
            Process process = pb.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            String error;
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
            int exitCode = process.waitFor();
            System.out.println("exitCode: " + exitCode);
            if (exitCode == 0) {
                return new BashResponse(output.toString(), "success: with command " + command, "1");
            } else {
                while ((error = err.readLine())!= null) {
                    output.append(error + "\n");
                }
                return new BashResponse(command, output.toString(), "0");
            }
        } catch (IOException e) {
            System.err.println("error running build command: " + e);
        } catch (InterruptedException e) {
            System.err.println("error running build command: " + e);
        }
        return new BashResponse(command, "failed: unknown error has occured", "0");
    }
}