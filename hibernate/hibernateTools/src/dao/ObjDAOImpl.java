package dao;
//ʵ��ʹ��ʱ��Object���ɶ�Ӧ��ʵ���ࡣ
public class ObjDAOImpl extends BaseHibernateDAO implements ObjDAO{

	@Override
	public Object get(int id) {
		// TODO Auto-generated method stub
		return (Object)super.get(Object.class, id);
	}
	public void add(Object obj){
		super.add(obj);
	}
	public void delete(Object obj){
		super.delete(obj);
	}
	public void update(Object obj){
		 super.update(obj);
	}

}
