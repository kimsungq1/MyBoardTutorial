package myboardtutorial.sample.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

// 서비스 정의를 위한 인터페이스

public interface SampleService {

	Map<String, Object> selectBoardList(Map<String, Object> map) throws Exception;

	void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception;

	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception;

	void deleteBoard(Map<String, Object> map);

}
