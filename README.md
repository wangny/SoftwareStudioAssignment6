##Explanation of the Design
1.Main�èS���ק��A�ܩ�Network�S���Ψ�A�ҥH���H�R���C
2.Character�D�n�O�w��H�������ܪ������A��l���]�w�����C��B�W�r�C
	display()�N����ܦb�L��l����m�W�C
	dislpay(int,int)�h�O��Ӷ�鲾�ʮɧ���m�N���b�j��W�C
	active��ܶ���e�����A�Afalse�|��b��l��mtrue��m�b�j�ꤧ�W�C
3.MainApplet�t�d�Ѿl���ʧ@�C
	setup()�̭��HControlP5�[�J��ӫ��s"ADD"�M"CLEAR"�A�٦���L��l���]�w�C
	draw()�̭���J�F�j��A�ΤT����ƨӨ��o���P���p��n��m�b�j��W����m�B��ƹ�����m�b�p�ꤧ�W�ɩҭn�Q��ܪ��W�r�B�H�η��ӥH�W���p��Q��m�b�j��W�ɩ����ӳQ��ܪ����Y�u���]�w�C
	mouseClicked()����p��Q�I��ɪ����A�]�Q��J�j��Ω�^��l��m�^�C
	Clear()�N�Ҧ����p�ꪬ�A�令false(��^��l��m)�C
	ADD()�N�Ҧ��p�ꪬ�A�令true(���j��W)�C
	loadData()�ϥΤW�ұ�ŪJSON�ɪ��覡�A�N�ݭn��JSAON��Ū�J�A���O�s���H���W�r�B�v���B�C�ⵥ��ơA�̫�A�N�U�H������b��l��m�W�C
### Operation
1.���U"ADD"�N�i�H�N�Ҧ����H������J�������j���W�A�åH�u��ܨ����p��(�u�]���Y������Ӧ��ʲӤ���)
2.���U"CLEAR"�h�O�N�Ҧ����H������^�쥻����m�W�C
3.�I�@�U�H�����N�i�H�N���J��������餤�A�A���@�U�N�i�H��^�쥻����m�C
4.��ƹ���m�b�H�����W�ɡA�|��ܸӤH�����W�١C
5.���U�Ʀr��(1~7)�N�i�H���STAR_WAR�����ơC
####Visualization
1.��H������b�j��W�ɡA��L�����Y���H�|��L�νu�s�_�ӡA���Y�V��u�V�ʡC
2.�C�ӤH���|���ۤv���C��A�W�r����ܤ]�O�C
3.��H���Q��m�b�j��W�ɡA�|�̷ө�m���Ӽƾ���a��m�b�j��W�C