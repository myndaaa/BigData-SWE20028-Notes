# Big Data Notes
This notes make use of the CLoudera Training VM, The VM image is can be found [here](https://drive.google.com/file/d/1pizgWHk6VAgCgpiMXeFbGqQ4KmY41NJ3/view)

### Getting Started: Transferring files back and forth via VM Ware

Once we turn on the VM, the following steps are done<br>
- Player>Removable Devices>Network Adapter> Settings
- Options> Shares Folders, select *Always enables*
- On folders, add your machines local folders path
- The files can be found on this path of the VM Training/File System/mnt/hgfs

**Setting it up**<br>
Open virtual machine > select the .vmx file/d/1pizgWHk6VAgCgpiMXeFbGqQ4KmY41NJ3/view

## Using HDFS
Hadoop is an **open-source framework** designed for storing and processing large datasets 
across multiple machines in a distributed environment. It's particularly useful for 
big data tasks because it allows large datasets to be stored, processed, and analyzed 
in parallel, which makes it much faster and scalable compared to traditional data processing.<br>

*HDFS (Hadoop Distributed File System):*

- file system that splits large files into smaller blocks and distributes them across multiple machines, creating a "distributed" storage.
- HDFS allows for fault tolerance by replicating these blocks on different machines, so data isn’t lost if one machine fails.

#### This command is used to upload files from the local file system to HDFS
```
hadoop fs -put shakespeare /user/training/shakespeare
```
#### Listing files in HDFS
```
hadoop fs -ls /user/training/

```

#### Removing files from HDFS
```
hadoop fs -rm /user/training/shakespeare

```

#### Viewing files in HDFS
````
hadoop fs -cat /user/training/shakespeare

````
### Text Editors in linux

1. Nano
  - Type: Command-line-based text editor
  - Interface: Runs directly in the terminal
  - User-Friendliness: Beginner-friendly with a simpler interface
  - Shortcut Guidance: Shows helpful shortcuts at the bottom of the screen (e.g., ^X for Exit, where ^ means "Ctrl")
  - Usage: Ideal for quick edits, especially when working over SSH or without a graphical interface
  - Sample usage: `nano myfile.txt`
2. Gedit
 - Type: Graphical text editor
 - Interface: GUI-based with menus, buttons, and a visual interface
 - User-Friendliness: Very beginner-friendly for users used to traditional text editors like Notepad on Windows
 - Syntax Highlighting: Supports syntax highlighting for coding, making it ideal for editing code
 - Usage: Good for writing code or editing files in a graphical Linux environment
 - Sample usage: `gedit myfile.txt &`
