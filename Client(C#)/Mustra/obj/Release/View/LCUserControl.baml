   M S B A M L   `   `   `  ���� A  =Mustra, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null)clr-namespace:Mustra.ViewMustra.View  3clr-namespace:Mustra.ViewModelMustra.ViewModel      Mustra.View.LCUserControl   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     @d2http://schemas.microsoft.com/expression/blend/2008     +localclr-namespace:Mustra.View     -vmclr-namespace:Mustra.ViewModel       � DataContext  -  'Mustra.ViewModel.LCUserControlViewModel   � 	Resources  �� 
TargetType   Hambuger �� Property �� Value �� 
TargetType � Cursor �� 
Background ��Name	 �� CornerRadius
 �� Color ��Name J� OpacityMask �� Triggers P� Property P� Value �� 
TargetName��%�  &	        �� " 	�.���  � �� �� " 	�.R��� $
 Hand�� Z� ._��� $ RadioBorder��$
��Auto��$��51��$	 0��$��1q�$��
-6,-2,-2,0q���Z� ���� $

 Gray��._�� $��38��.+��� $ RadioContent��$��Center=�$��Center=�
 �   ��� $ 	RadioMark��$��
-2,0,184,0q����	#FFCB2525$	 1��$��0�� P�  �@d�	IsChecked$
 trueY�. ��� $ RadioBorder�� � �� �� $
 	#FF3778D6��.��� 
�������.+��� .+��� $��46�����	#FF3778D6.+���  �� TextAlignment$ Center=�$��Learning Curve��$��35��$��	0,5.2,0,0q�
�������$��24(�$��Impact)���  �� Orientation$ 
Horizontal=�$��39��
�������.+��� $	��141��._��� $	��140��.+��� $��38��$��1,1,1,1q�$��2,0,0,0q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��137��.+�	�  	� 	GroupName$
 menu��$��Total��#��[  $	��137��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��38�� J� RenderTransformOrigin$ 0.503,0.362&����� *	LoadTotal+��Z� ��Z� �� $	��141��._��� $	��140��.+��� $��38��$��1,1,1,1q�$��2,0,0,0q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��137��.+�	� $
 menu��$��OneRule��#��[  $	��137��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��38��$ 0.503,0.362&����� *LoadOR+��Z� ��Z� �� $	��141��._��� $	��140��.+��� $��38��$��1,1,1,1q�$��2,0,0,0q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��137��.+�	� $
 menu��$��
NaiveBayes��#��[  $	��137��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��38��$ 0.503,0.362&����� *LoadNB+��Z� ��Z� �� $	��141��._��� $	��140��.+��� $��38��$��1,1,1,1q�$��2,0,0,0q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��137��.+�	� $
 menu��$	��J48��#��[  $	��137��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��38��$ 0.503,0.362&����� *
LoadTree+��Z� ��Z� �� $	��368��.+��� $	��353��$��0,6,0,0q�._��� .+��� $	��352������ *Contentview+