package com.gwtjs.icustom.attachments.dao;

import java.util.List;

import org.jboss.logging.Param;
import org.omg.CORBA.portable.ApplicationException;

import com.gwtjs.icustom.attachments.model.AttachmentVO;
import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;

public interface IAttachmentDao {

	/**
	 * 创建附件
	 * 
	 * @param newAttachment
	 * @return
	 */
	int createAttachment(AttachmentVO newAttachment);

	/**
	 * 产生批次号
	 * 
	 * @return
	 */
	int generateBatchId();

	/**
	 * 删除附件
	 * 
	 * @param existedAttachment
	 * @return
	 */
	int deleteAttachment(AttachmentVO existedAttachment);

	/**
	 * 删除一批附件，根据附件批次号
	 * 
	 * @param existedAttachment
	 * @return
	 */
	int deleteAttachmentList(AttachmentVO existedAttachment);

	/**
	 * 查询附件信息
	 * 
	 * @param existedAttachment
	 * @return
	 */
	AttachmentVO findAttachment(AttachmentVO existedAttachment);

	/**
	 * 获取一批附件列表，根据批次号
	 * 
	 * @param existedAttachment
	 * @return
	 */
	List<AttachmentVO> findAttachmentList(AttachmentVO existedAttachment);

	/**
	 * 更新批次id
	 * 
	 * @author lWX80565
	 * @since 2013-4-23
	 * @param attachments
	 * @param batchId
	 */
	//void updateAttachmentBatchId(List<AttachmentVO> attachments, @Param("batchId") int batchId);

	/**
	 * 更新
	 * 
	 * @author twx242107
	 * @since 2015-6-17
	 * @param attachments
	 * @param batchId
	 */
	void updateAttachmentByHaedoc(AttachmentVO attachmentVO);

	/**
	 * 分页查找
	 *
	 * @author f00196405
	 * @since 2011-12-6
	 * @param exportTaskVO
	 * @param pageVO
	 * @return
	 */
	public PagedResult<AttachmentVO> findAttachmentByHaedocList(AttachmentVO existedAttachment, PageVO pageVO)
			throws ApplicationException;

}
