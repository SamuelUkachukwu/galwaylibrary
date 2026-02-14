package usecases;

import adapters.LibraryRepository;
import entities.Member;
import java.util.List;

public class ListMembersUseCase {

    private final LibraryRepository libraryRepository;

    public ListMembersUseCase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute() {

        List<Member> members = libraryRepository.getAllMembers();
        for (Member m : members) {
            System.out.println(m);
        }

    }
}
