package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // 얘가 활성화되어있으면 test 완료 후 rollback 한다
public class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {

        // given
        Memo newMemo = new Memo(2, "insertMemoTest");

        // when
        jdbcMemoRepository.save(newMemo);

        // then
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        assertEquals(result.get().getText(), newMemo.getText());
    }

    @Test
    void foundAllMemoTest() {
        List<Memo> memoList = jdbcMemoRepository.findAll();
        System.out.println("hello memo" + memoList);
        assertNotNull(memoList);
    }
}
