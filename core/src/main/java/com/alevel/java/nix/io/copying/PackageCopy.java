package com.alevel.java.nix.io.copying;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;

public class PackageCopy extends SimpleFileVisitor<Path> {

    private static final Logger log = LoggerFactory.getLogger(PackageCopy.class);

    private final Path source;
    private final Path target;

    public PackageCopy(Path source, Path target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDirectory = target.resolve(source.relativize(dir));
        try {
            Files.copy(dir, newDirectory);
        } catch (FileAlreadyExistsException e) {
            log.error("file {} already exists", newDirectory);
            return SKIP_SUBTREE;
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newFile = target.resolve(source.relativize(file));
        try {
            Files.copy(file, newFile);
        } catch (IOException e) {
            log.error("can't copy file {} to new file {}", file, newFile);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
        if (e instanceof FileSystemLoopException) {
            log.info("this is file system loop exception");
        } else {
            log.error("can't visit file {}", file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
        return CONTINUE;
    }

}
