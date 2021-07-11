package com.model.repository.contractDetail;

import com.model.entity.contractDetail.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService,Long> {
}
