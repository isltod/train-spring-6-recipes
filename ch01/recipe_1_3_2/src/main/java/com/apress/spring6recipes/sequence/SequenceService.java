package com.apress.spring6recipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {

	// configuration 클래스에서 @Bean으로 넣어주는게 아니라 여기서 자동으로 Autowired
    @Autowired
	private SequenceDao sequenceDao;

	public String generate(String sequenceId) {
		var sequence = sequenceDao.getSequence(sequenceId);
		var value = sequenceDao.getNextValue(sequenceId);
		return sequence.prefix() + value + sequence.suffix();
	}
}
