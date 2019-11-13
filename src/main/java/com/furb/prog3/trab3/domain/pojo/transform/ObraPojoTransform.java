package com.furb.prog3.trab3.domain.pojo.transform;

import com.furb.prog3.trab3.domain.entity.ObraEntity;
import com.furb.prog3.trab3.domain.pojo.ObraPojo;

public class ObraPojoTransform implements BasePojoTransform<ObraPojo, ObraEntity> {

	@Override
	public ObraEntity transformTo(ObraEntity entity, ObraPojo pojo) {
		return null;
	}

	@Override
	public ObraPojo transformFrom(ObraPojo pojo, ObraEntity entity) {
		return null;
	}

}
