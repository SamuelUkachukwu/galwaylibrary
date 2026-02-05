package usecases;


import entities.Member;


public interface MemberRepository {
   void add(Member member);
   Member findById(String id);
}