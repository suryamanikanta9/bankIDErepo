package org.cap.test.bankapp;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ BankAppSuite.class, BankAppTestCase.class, SampleTestCase.class })
@IncludeCategory({ReportCategory.class})
@ExcludeCategory({LoginCategory.class})
public class MyCategory {

}
