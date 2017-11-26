package com.gwtjs.icustom.attachments.service;

import java.util.List;

import com.gwtjs.icustom.attachments.model.AttachmentVO;
import com.gwtjs.icustom.entity.PageVO;
import com.gwtjs.icustom.entity.PagedResult;

public interface IAttachmentQueryService {

	public List<AttachmentVO> findAttachments(AttachmentVO attachmentVO);

	public PagedResult<AttachmentVO> findAttachmentList(AttachmentVO attachmentVO, PageVO pageVO);

}
