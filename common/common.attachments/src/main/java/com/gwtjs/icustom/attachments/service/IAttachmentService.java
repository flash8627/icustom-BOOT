package com.gwtjs.icustom.attachments.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.omg.CORBA.portable.ApplicationException;

import com.gwtjs.icustom.attachments.model.AttachmentVO;
import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;

/**
 * 附件服务
 */
@Path("")
@Produces("application/json")
public interface IAttachmentService {

	/**
	 * 创建附件
	 * 
	 * @param newAttachment
	 */
	void createAttachment(AttachmentVO newAttachment) throws ApplicationException;

	/**
	 * 生成批次号
	 * 
	 * @return
	 */
	int generateBatchId();

	/**
	 * 根据附件Id删除附件，附件文件本身并不删除，以供审计使用
	 * 
	 * @param verifyCode
	 *            验证码
	 * @param existedAttachment
	 *            必须的属性：attchmentId attachmentType
	 */
	@DELETE
	@Path("/single")
	void deleteAttachment(@QueryParam("verify") String verifyCode, @QueryParam("") AttachmentVO existedAttachment)
			throws ApplicationException;

	/**
	 * 删除附件
	 * 
	 * @param existedAttachment
	 *            必须的属性：attchmentId attachmentType
	 * @throws ApplicationException
	 */
	void deleteAttachment(AttachmentVO existedAttachment) throws ApplicationException;

	/**
	 * 根据批次Id删除附件
	 * 
	 * @param existedAttachment
	 *            必须的属性：attchmentId attachmentType
	 */
	void deleteAttachmentList(AttachmentVO existedAttachment) throws ApplicationException;

	/**
	 * 根据附件Id查找附件
	 * 
	 * @param existedAttachment
	 *            必须的属性：attchmentId attachmentType
	 * @return
	 */
	AttachmentVO findAttachment(AttachmentVO existedAttachment) throws ApplicationException;

	/**
	 * 根据批次Id查找附件列表
	 * 
	 * @param existedAttachment
	 *            必须的属性：batchId attachmentType
	 * @return
	 */
	List<AttachmentVO> findAttachmentList(AttachmentVO existedAttachment) throws ApplicationException;

	/**
	 * 初始化附件中的下载和删除URL，此方法不应暴露给远程调用
	 * 
	 * @param attachments
	 *            附件列表
	 * @param grantDownload
	 *            赋予下载URL
	 * @param grantDelete
	 *            赋予删除URL
	 */
	void initAttachmentUrls(List<AttachmentVO> attachments, boolean grantDownload, boolean grantDelete);

	/**
	 * 更新批次id
	 * 
	 * @author lWX80565
	 * @since 2013-4-22
	 * @param attachmentIds
	 * @param batchId
	 */
	void updateAttachmentBatchId(List<AttachmentVO> attachments, int batchId);

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
