   M S B A M L   `   `   `  ����A  =Mustra, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null)clr-namespace:Mustra.ViewMustra.View  5      3clr-namespace:Mustra.ViewModelMustra.ViewModel  5          Mustra.View.LCUserControl   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      +localclr-namespace:Mustra.View     5      -vmclr-namespace:Mustra.ViewModel     5        � DataContext  5
      -  'Mustra.ViewModel.LCUserControlViewModel  5   
   6&    � 	Resources 5       �� 
TargetType   Hambuger �� Property �� Value �� 
TargetType � Cursor �� 
Background ��Name	 �� CornerRadius
 �� Color ��Name J� OpacityMask �� Triggers P� Property P� Value �� 
TargetName��%  &	        �� 5   
   " 	�6   .�5      ��  � �� 5      �� 5      " 	�6&   .R�5      �� $
 Hand��6*    68   Z� ._�5      �� $ RadioBorder��6z   $
��Auto��6%   $��51��62   $	 0��6>   $��1q�6f   $��
-6,-2,-2,0q�6�   ��6O   Z� ��5   "   �� 5   &   $

 Gray��66   6E   ._�5   "   � $��38��6'   .+�5   &   �� $ RadioContent��67   $��Center=�6O   $��Center=�6l   
 �   �6�   �� 5   &   $ 	RadioMark��6i   $��
-2,0,184,0q�6-   ���	#FFCB2525$	 1��6X   $��0��6|   5   #   5      5       5!      P� 5"       �@d�	IsChecked$
 trueY�6;   . �5#   "   �� $ RadioBorder��6)    � �� 5$   &   �� 5%   *   $
 	#FF3778D6��6:   6N   5'   #   5(      5*      5,      5-      5.      .��5/      � 
�������.+�50   
   �� .+�51      �� $��46��6   ���	#FF3778D6.+�52      ��  �� TextAlignment$ Center=�6   $��Learning Curve��53      $��35��62   $��	0,5.2,0,0q�6>   
�������$��24(�6d   $��Impact)�6r   6�   54      �� 55       �� Orientation$ 
Horizontal=�6   $��39��62   
�������.+�56      �� $	��141��6   ._�57      �� $	��140��6!   .+�58      �� $��38��6!   $��1,1,1,1q�6-   $��2,0,0,0q�6G   ._�59      �� $ 
Horizontal=�6)   $��Center=�6B   $��-1q�6_   $	��137��6k   .+�5:   "   	�  	� 	GroupName$
 menu��5<   %   $��Total��66   #��[  6G   $	��137��5=   %   $��20(�61   ���	#FFF1F1F1$��Impact)�6V   $��Center=�6j   $��Center=�6�   $��38��6�    J� RenderTransformOrigin$ 0.503,0.362&�6�   ��5;   %   �� *	LoadTotal+��5<   i   Z� ��5=   �   Z� 6�   5>      5?      5@      5A      �� 5B      $	��141��6   ._�5C      �� $	��140��6!   .+�5D      �� $��38��6!   $��1,1,1,1q�6-   $��2,0,0,0q�6G   ._�5E      �� $ 
Horizontal=�6)   $��Center=�6B   $��-1q�6_   $	��137��6k   .+�5F   "   	� $
 menu��5H   -   $��OneRule��6>   #��[  6Q   $	��137��5I   1   $��20(�6=   ���	#FFF1F1F1$��Impact)�6b   $��Center=�6v   $��Center=�6�   $��38��6�   $ 0.503,0.362&�6�   ��5G   -   �� *LoadOR+��5H   s   Z� ��5I   �   Z� 6�   5J      5K      5L      5M      �� 5N      $	��141��6   ._�5O      �� $	��140��6!   .+�5P      �� $��38��6!   $��1,1,1,1q�6-   $��2,0,0,0q�6G   ._�5Q      �� $ 
Horizontal=�6)   $��Center=�6B   $��-1q�6_   $	��137��6k   .+�5R   "   	� $
 menu��5T   %   $��
NaiveBayes��66   #��[  6L   $	��137��5U   %   $��20(�61   ���	#FFF1F1F1$��Impact)�6V   $��Center=�6j   $��Center=�6�   $��38��6�   $ 0.503,0.362&�6�   ��5S   %   �� *LoadNB+��5T   n   Z� ��5U   �   Z� 6�   5V      5W      5X      5Y      �� 5Z      $	��141��6   ._�5[      �� $	��140��6!   .+�5\      �� $��38��6!   $��1,1,1,1q�6-   $��2,0,0,0q�6G   ._�5]      �� $ 
Horizontal=�6)   $��Center=�6B   $��-1q�6_   $	��137��6k   .+�5^   "   	� $
 menu��5`   %   $	��J48��66   #��[  6E   $	��137��5a   %   $��20(�61   ���	#FFF1F1F1$��Impact)�6V   $��Center=�6j   $��Center=�6�   $��38��6�   $ 0.503,0.362&�6�   ��5_   %   �� *
LoadTree+��5`   g   Z� ��5a   �   Z� 6�   5b      5c      5d      5e      5f      �� 5g      $	��368��6   .+�5h      �� $	��353��6   $��0,6,0,0q�6&   ._�5i      �� .+�5j      �� $	��352��6I   ��6)   �� *Contentview+6X   5k      5l      5m      5n      5o      5p      