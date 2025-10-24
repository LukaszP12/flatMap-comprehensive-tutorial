package pl.piwowarski.flatMapDemo.streams.exampleWithRecursion3;

import java.util.List;

class Folder {
    String name;
    List<FileEntry> files;
    List<Folder> subFolders;

    public Folder(String name, List<FileEntry> files, List<Folder> subFolders) {
        this.name = name;
        this.files = files;
        this.subFolders = subFolders;
    }
}
