package usecases;

import entities.Member;
import adapters.LibraryRepository;

public class AddMember {
    
    private final LibraryRepository libraryRepository;

    public AddMember(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute(Member member) {
        libraryRepository.addMember(member);
    }
}