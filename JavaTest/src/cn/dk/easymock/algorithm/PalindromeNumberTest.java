package cn.dk.easymock.algorithm;


import cn.dk.algorithm.leetcode.PalindromeNumber;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Rule;

public class PalindromeNumberTest extends EasyMockSupport {
    @Rule
    public EasyMockRule easyMockRule = new EasyMockRule(this);

    @Mock
    private PalindromeNumber palindromeNumber;


}
