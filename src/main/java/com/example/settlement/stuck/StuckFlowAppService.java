package com.example.settlement.stuck;


import com.example.settlement.common.event.UnexpectedEvent;
import com.example.settlement.stuck.infra.event.FlowStuckCreated;
import com.example.settlement.stuck.model.StuckFlowModel;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.tuple.Pair;

import java.rmi.UnexpectedException;

import static com.example.settlement.stuck.infra.enums.StuckTypeEnum.Clearing;

/**
 *
 * @author yangwu_i
 * @date 2023/4/29 10:42
 */
public class StuckFlowAppService {
    @Resource
    StuckFlowRepo stuckFlowRepository;

    @Resource
    private StuckFlowDomainService stuckFlowDomainService;
    public ExecResult tradeClearingStucked(Long userId, String tradeId, Integer tradeType, int errorNo, String errorMsg) {
        StuckFlowModel model = stuckFlowRepository.findStuckModel(Clearing.getCode(), tradeId, tradeType);
        if (model != null) {
            return ExecResult.success();
        }

        Pair<FlowStuckCreated, UnexpectedEvent> result = stuckFlowDomainService.tradeClearingStucked(userId, tradeId, tradeType, errorNo, errorMsg);
        if (result.getLeft() != null) {
            stuckFlowRepository.handle(result.getLeft());
            return ExecResult.success();
        } else {
            return ExecResult.error(result.getRight());
        }
    }
}