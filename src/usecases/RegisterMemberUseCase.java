package usecases;

import entities.Member;
import adapters.LibraryRepository;

public class RegisterMemberUseCase {

    private final LibraryRepository libraryRepository;

    public RegisterMemberUseCase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute(Member member) {
        libraryRepository.addMember(member);
    }
}