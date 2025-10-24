package pl.piwowarski.flatMapDemo.streams.exampleWithRecursion3;

import java.util.List;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {
        Folder images = new Folder("Images",
                List.of(new FileEntry("photo1.jpg", 500),
                        new FileEntry("photo2.jpg", 800)),
                List.of()
        );

        Folder docs = new Folder("Documents",
                List.of(new FileEntry("cv.pdf", 200),
                        new FileEntry("notes.txt", 50)),
                List.of()
        );

        Folder root = new Folder("Root",
                List.of(new FileEntry("readme.md", 10)),
                List.of(images, docs)
        );

        Stream<FileEntry> flatten = flatten(root);
        int totalSize = flatten.mapToInt(file -> file.size).sum();
        System.out.println("Total size: " + totalSize + " KB");
    }

    static Stream<FileEntry> flatten(Folder folder) {
        return Stream.concat(
                folder.files.stream(),  // current folder's files
                folder.subFolders.stream()
                        .flatMap(Main::flatten) // recursively flatten subfolders
        );
    }
}
