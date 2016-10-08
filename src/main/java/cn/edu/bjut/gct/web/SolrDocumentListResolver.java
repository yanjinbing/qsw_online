package cn.edu.bjut.gct.web;

import java.beans.FeatureDescriptor;
import java.util.Iterator;

import javax.el.BeanELResolver;
import javax.el.ELContext;
import javax.el.ELResolver;

import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

@Service
public class SolrDocumentListResolver extends ELResolver {
	private BeanELResolver beanResolver = new BeanELResolver();

	@Override
	public Object getValue(ELContext context, Object base, Object property) {
		Object object = null;
		if (base instanceof SolrDocumentList) {
			try {
				object = beanResolver.getValue(context, base, property);
			} catch (Exception e1) {
				context.setPropertyResolved(false);
			}
		}
		return object;
	}

	@Override
	public Class<?> getType(ELContext context, Object base, Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(ELContext context, Object base, Object property, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isReadOnly(ELContext context, Object base, Object property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getCommonPropertyType(ELContext context, Object base) {
		// TODO Auto-generated method stub
		return null;
	}

}
