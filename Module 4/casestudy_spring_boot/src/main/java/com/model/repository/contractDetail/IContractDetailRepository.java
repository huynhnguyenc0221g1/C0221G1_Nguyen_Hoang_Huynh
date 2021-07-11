package com.model.repository.contractDetail;

import com.model.entity.contractDetail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    @Query(value = "select * from contract_detail cd where cd.contract_detail_id = ?1", nativeQuery = true)
    Page<ContractDetail> findAllByContractId(Long id, Pageable pageable);
}
