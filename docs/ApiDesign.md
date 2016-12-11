# Zero API���ԭ��


## ���ʶ��壺
* ��״̬(stateless) �ӿͻ��˵���������ÿ�����󶼱����������������������Ϣ��
* �ݵ���(Idempotence)��һ�κͶ������ĳ��Դʱ�ɾ���ͬ��������
* ��ȫ������ִ�к󲻻�ı��������״̬���������ⷢ���κ���Ϣ�Ĳ���


## �������
* ��HTTP��ΪӦ�ò�Э����Ǵ����Э��
* URI���Ҫ������Դ����������
* URI���Ҫ���ڿͻ�������������ݿ�ṹ

## ��ƹ淶
* RequestӦΪ��״̬�ģ���˲���������session id
* ����GET, POST, PUT, DELETE 4������
* GETΪ��ȫ��������������Ϊ����ȫ����
* POSTΪ���ݵ��Բ�������������Ϊ�ݵ��Բ���
* POST��PUTʱ����request body���ṩ��Դ���걸��Ϣ
* URIͳһΪСд��ĸ����-���ָ��

## �����Թ淶
* ��Զ����SSL���д���
* ��Դ����ͳһΪ���ʵĸ�����ʽ
* ���ظ�ʽĬ�ϲ���JSON
* ��GET�⣬�������������ͳһ����JSON

## ���Լ��
* һ����Դ��Ӧһ��URL
* һ����Դ��Ӧһ��DTO
* access_token������DTO�ⲿ

### ������Ϣ��ʽ
{
	status:"status",
	errors:[{
		type:"",
		source:"",
		message:"",
		detail:""
	},...]
}

* status: �����״̬����
* errors�������б���������ܶ����
* type�� ���������
* source: ����ĳ����������ֶ���
* message����ʾ���û��ļ�����
* detail����ʾ�������ߵ���ϸ����

### ��������
* FIELD_ERROR��DTO�Ϸ�����������֤����
* GLOBAL_ERROR��ȫ�ִ���
* RUNTIME_EXCEPTION�� ��Service�׳�������ʱ����

## Ȩ�޿���
����REST request ӦΪ��״̬�ģ���˲��ܽ��û��ĵ�½״̬�󶨵�session֮�У����APIӦͨ��access token�����Ʒ���Ȩ�ޡ��û��ڵ�¼ʱ��Ҫpost���û�������������÷����������ɵ�access token����������֤�û���ݺ󷢻�token���ͻ��ˣ��ͻ����ڱ���һ����ȫ�ĵط�������һtoken������֮���ÿ��request�ж�������һtoken��������ݡ�  

���ǵ�JS webapp��web storage�޷�����XSS (ʹ��webpack��ܶ������lab�������ͬһ��js)������Ƽ���token��http-only����ʽ�洢��cookie�У�ʹǰ��JS�޷�������token��  

## 4���������ݿ�CRUD��ӳ���ϵ
* GET�������ڶ�ȡ��Դ
* POST�������ڴ�������Դ(id�ɷ�������ָ��)
* PUT���������޸���Դ���򴴽���Щid�ɿͻ�������������Դ
* DELETE��������ɾ����Դ

�����ͣ�POST���������޸���Դ����Ϊ�޸Ĳ���Ӧ�����ݵ��Բ���������id�ɿͻ�������������Դ����Ӧ�ṩPOST�����������������޸Ĳ����ϲ���PUT��ִ��saveOrUpdate��  


## URI��Ʒ�����

���� | ����
--- | ---
GET /productions | ��ȡ���в�Ʒ��Ϣ�б�
GET /productions?limit=10&start=100&orderby=name | ���������������Ĳ�ѯ
GET /productions/1234 | ��ȡĳ���ض���Ʒ����Ϣ�����ڲ�ƷID
GET /productions/1234/snapshot | ��ȡidΪ1234��һ��Ʒ�İ�������detail�ĸ�����Դ
GET /productions/1234/venders | ��ȡidΪ1234��һ��Ʒ�Ĺ�Ӧ����Ϣ
POST /productions | ����һ���µĲ�Ʒ�����ݸ�ʽΪJSON����RequestBody��
POST /productions/1234 | ����һ��vender����Ʒ1234��vender���ݷ���RequestBody��
PUT /productions/1234 | ���ӻ��޸�ĳ��Ʒ��Ϣ�����ݸ�ʽΪJSON����RequestBody��
DELETE /productions | ɾ�����в�Ʒ��Ϣ
DELETE /productions/1234 | ɾ��ĳ��Ʒ��Ϣ




