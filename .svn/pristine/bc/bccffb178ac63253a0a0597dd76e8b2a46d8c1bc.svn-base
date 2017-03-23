package com.sd.farmework.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.farmework.common.BaseInfo;
import com.sd.farmework.mapper.CgOrdersDetailMapper;
import com.sd.farmework.mapper.CgOrdersInfoMapper;
import com.sd.farmework.pojo.CgOrdersInfoDetail;
import com.sd.farmework.pojo.RemoteObjectDetail;
import com.sd.farmework.service.CgOrdersInfoService;
/**
 * 入库管理
 * @author xsj
 * 2017年1月5日15:46:20
 */
@Service
public class CgOrdersInfoServiceImpl   extends BaseInfoServiceImpl  implements CgOrdersInfoService {

	private static Logger logger = Logger.getLogger(CgOrdersInfoServiceImpl.class);
	
	@Autowired
	private CgOrdersInfoMapper baseMapper;
	@Autowired
	private CgOrdersDetailMapper baseMapper1;

	public CgOrdersInfoMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(CgOrdersInfoMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public List queryByOrderNo(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.queryByOrderNo(obj);
	}

	@Override
	public List weiCharQueryList(BaseInfo obj) {
		// TODO Auto-generated method stub
		return baseMapper.weiCharQueryList(obj);
	}

	@Override
	public void updateRkCgOrderDetailInfo(BaseInfo obj) {
		// TODO Auto-generated method stub
		baseMapper.updateRkCgOrderDetailInfo(obj);
	}

	@Override
	public void updateRkCgOrdeInfoStauts(BaseInfo obj) {
		// TODO Auto-generated method stub
		baseMapper.updateRkCgOrdeInfoStauts(obj);
	}

	@Override
	public void updateNum(BaseInfo obj) {
		// TODO Auto-generated method stub
		baseMapper.updateNum(obj);
	}
	/**
	 *插入主表及子表信息 
	 * @throws Exception 
	 */
	public void addData(BaseInfo obj, List detailList) throws Exception {

		CgOrdersInfoDetail detailDto = null;
		try {
			//System.out.println("主表数据插入开始");
			logger.info("主表数据插入开始");
			baseMapper.add(obj);
			//System.out.println("主表数据插入结束");
			logger.info("主表数据插入结束");
			
			//插入子表数据
			for (int i = 0; i < detailList.size(); i++) {
				RemoteObjectDetail detail = (RemoteObjectDetail)detailList.get(i);
				detailDto = new CgOrdersInfoDetail();
				detailDto.setOrderNo(detail.getOrderNo());
				detailDto.setStockNo(detail.getStockNo());
				detailDto.setStockName(detail.getStockName());
				detailDto.setStandard(detail.getStandard());
				detailDto.setUnit(detail.getUnit());
				detailDto.setNum(detail.getNum());
				detailDto.setTaxationPrice(detail.getTaxationPrice());
				detailDto.setPrice(detail.getPrice());
				detailDto.setDiscountRate(detail.getDiscountRate());
				detailDto.setAmount(detail.getAmount());
				detailDto.setTaxationType(detail.getTaxationType());
				detailDto.setTaxationRate(detail.getTaxationRate());
				detailDto.setSum(detail.getSum());
				detailDto.setCreateUserId(detail.getCreateUserId());
				detailDto.setCreateUserName(detail.getCreateUserId());
				detailDto.setLastUpdateUserId("");
				detailDto.setLastUpdateUserName("");
				//System.out.println("订单详情数据detailDto="+detailDto.toString());
				logger.info("订单详情数据detailDto="+detailDto.toString());
				
				logger.info("子表数据插入开始");
				//System.out.println("子表数据插入开始");
				baseMapper1.add(detailDto);
				//System.out.println("子表数据插入结束");
				logger.info("子表数据插入结束");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("11");
		}
		
	}
}
