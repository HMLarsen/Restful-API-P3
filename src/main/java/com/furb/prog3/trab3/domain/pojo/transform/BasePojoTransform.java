package com.furb.prog3.trab3.domain.pojo.transform;

import com.furb.prog3.trab3.domain.entity.BaseEntity;
import com.furb.prog3.trab3.domain.pojo.BasePojo;

public interface BasePojoTransform<P extends BasePojo, E extends BaseEntity> {

	E transformTo(E entity, P pojo);

	P transformFrom(P pojo, E entity);

}
