package com.apress.spring6recipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @ComponenetScan 안 붙여도, Main에서 basePackages로 지정해줘서 스캔이 된다.
@Service
public class SequenceService {

	// 하지만 여기처럼 클래스 필드에 직접 @Autowired 하는건 비추라고...
	// configuration 클래스에서 @Bean으로 넣어주는게 아니라 여기서 자동으로 Autowired
    // @Autowired
	private SequenceDao sequenceDao;
	// 클래스 필드를 배열, 리스트 맵으로 선언하면 맞는 타입을 다 찾아서 넣어준다.

	// 또는 세터 또는 생성자로 주입...이게 추천...
	@Autowired
	// 생성자가 하나뿐이라서 @Autowired 생략 가능 - 결국 이래서 @Autowired가 생략되도 되는 것처럼 보인다...
	public SequenceService(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}

	public String generate(String sequenceId) {
		var sequence = sequenceDao.getSequence(sequenceId);
		var value = sequenceDao.getNextValue(sequenceId);
		return sequence.prefix() + value + sequence.suffix();
	}
}
