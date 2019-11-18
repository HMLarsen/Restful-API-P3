package com.furb.prog3.trab3.domain.pojo.transform;

import com.furb.prog3.trab3.domain.entity.BaseEntity;
import com.furb.prog3.trab3.domain.pojo.BasePojo;

public interface BaseTransform<P extends BasePojo, E extends BaseEntity> {

	E transformToEntity(P pojo);

	E updateEntity(P pojo, E entity);

}
