package com.apress.spring6recipes.sequence;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // 이걸 밖으로 빼면 catch 등을 넣으라고 오류가...
        try (var context = new AnnotationConfigApplicationContext()) {

            // GenericApplicationContext에서 온 registerBean으로 먼저 빈을 등록하고
            // 타입 + Supplier + 빈 재정의 클래스 매개변수로 빈 등록
            context.registerBean(PrefixGenerator.class, () -> new DatePrefixGenerator("yyyyMMdd"));
            context.registerBean(Sequence.class, () -> {
                var seq = new Sequence("A", 100000);
                context.getBeanProvider(PrefixGenerator.class).ifUnique(seq::setPrefixGenerator);
                return seq;
            }, new SequenceBeanDefinitionCustomizer());
            // 실제로 빈은 여기서 생성되고
            context.refresh();
            // 다시 빈을 가져와야 쓸 수 있다..왜 이렇게 복잡한 걸 쓰는 건가...
            var generator = context.getBean(Sequence.class);

            System.out.println(generator.nextValue());
            System.out.println(generator.nextValue());
        }
    }
}

// 이건 위에서 람다 코드로 보통 쓴다고 주장하는데...이게 뭔 가독성인지...
class SequenceBeanDefinitionCustomizer implements BeanDefinitionCustomizer {

    @Override
    public void customize(BeanDefinition bd) {
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        bd.setLazyInit(true);
    }
}
