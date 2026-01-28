package com.apress.spring6recipes.sequence;

// DAO는 인터페이스로 정의하는게 일반적인가?
public interface SequenceDao {

    // 일단 Sequence에서 만든 ID를 이용해 도메인 객체를 가져온다...
    Sequence getSequence(String sequenceId);

    int getNexValue(String sequenceId);
}
