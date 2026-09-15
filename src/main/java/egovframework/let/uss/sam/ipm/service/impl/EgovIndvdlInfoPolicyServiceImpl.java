package egovframework.let.uss.sam.ipm.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.let.uss.sam.ipm.service.EgovIndvdlInfoPolicyService;
import egovframework.let.uss.sam.ipm.service.IndvdlInfoPolicy;
import jakarta.annotation.Resource;

/**
 * 개인정보보호정책를 처리하는 ServiceImpl Class 구현
 * @author 공통서비스 장동한
 * @since 2009.07.03
 * @version 1.0
 * @see <pre>
 * &lt;&lt; 개정이력(Modification Information) &gt;&gt;
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.07.03  장동한          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */
@Service("egovIndvdlInfoPolicyService")
public class EgovIndvdlInfoPolicyServiceImpl extends EgovAbstractServiceImpl
        implements EgovIndvdlInfoPolicyService {

    @Resource(name = "onlineIndvdlInfoPolicyDao")
    private IndvdlInfoPolicyDao dao;

    @Resource(name = "egovIndvdlInfoPolicyIdGnrService")
    private EgovIdGnrService idgenService;

    /**
     * 개인정보보호정책를(을) 목록을 조회 한다.
     * @param OnlinePoll 회정정보가 담김 VO
     * @return List
     */
	@Override
	public List<?> selectIndvdlInfoPolicyList(ComDefaultVO searchVO) {
        return dao.selectIndvdlInfoPolicyList(searchVO);
    }

    /**
     * 개인정보보호정책를(을) 목록 전체 건수를(을) 조회한다.
     * @param searchVO  조회할 정보가 담긴 VO
     * @return int
     */
    @Override
	public int selectIndvdlInfoPolicyListCnt(ComDefaultVO searchVO) {
        return dao.selectIndvdlInfoPolicyListCnt(searchVO);
    }

    /**
     * 개인정보보호정책를(을) 상세조회 한다.
     * @param searchVO 조회할 정보가 담긴 VO
     * @return List
     */
    @Override
	public IndvdlInfoPolicy selectIndvdlInfoPolicyDetail( IndvdlInfoPolicy indvdlInfoPolicy) {
        return dao.selectIndvdlInfoPolicyDetail(indvdlInfoPolicy);
    }

    /**
     * 개인정보보호정책를(을) 등록한다.
     * @param indvdlInfoPolicy 개인정보보호정책 정보가 담긴 VO
     */
    @Override
	public void insertIndvdlInfoPolicy(IndvdlInfoPolicy indvdlInfoPolicy) {
        String sMakeId;
		try {
			sMakeId = idgenService.getNextStringId();
		} catch (FdlException e) {
			throw new BaseRuntimeException(e);
		}
        indvdlInfoPolicy.setIndvdlInfoId(sMakeId);
        dao.insertIndvdlInfoPolicy(indvdlInfoPolicy);
    }

    /**
     * 개인정보보호정책를(을) 수정한다.
     * @param indvdlInfoPolicy 개인정보보호정책 정보가 담긴 VO
     */
    @Override
	public void updateIndvdlInfoPolicy(IndvdlInfoPolicy indvdlInfoPolicy) {
        dao.updateIndvdlInfoPolicy(indvdlInfoPolicy);
    }

    /**
     * 개인정보보호정책를(을) 삭제한다.
     * @param indvdlInfoPolicy 개인정보보호정책 정보가 담긴 VO
     */
    @Override
	public void deleteIndvdlInfoPolicy(IndvdlInfoPolicy indvdlInfoPolicy) {
        dao.deleteIndvdlInfoPolicy(indvdlInfoPolicy);
    }

}
