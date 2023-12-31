package com.airrowing.system.controller;

import com.airrowing.system.dto.ApiDataResponse;
import com.airrowing.system.pojo.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Tag(
        name = "test",
        description = "测试login"
)
@RestController
@CrossOrigin // 跨域
@RequestMapping("/user")
public class LoginConstController {
    @GetMapping("/info")
    public ApiDataResponse<LoginBack> testloging() {
        System.out.println("it is called");
        LoginBack userInfo = new LoginBack();
        userInfo.setId("4291d7da9005377ec9aec4a71ea837f");
        userInfo.setName("天野远子");
        userInfo.setUsername("admin");
        userInfo.setPassword("");
        userInfo.setAvatar("/avatar2.jpg");
        userInfo.setStatus(1);
        userInfo.setTelephone("");
        userInfo.setLastLoginIp("27.154.74.117");
        userInfo.setLastLoginTime(1534837621348L);
        userInfo.setCreatorId("admin");
        userInfo.setCreateTime(1497160610259L);
        userInfo.setMerchantCode("TLif2btpzg079h15bk");
        userInfo.setDeleted(0);
        userInfo.setRoleId("admin");

        LoginRoleInfo loginRoleInfo = new LoginRoleInfo();

        loginRoleInfo.setId("admin");
        loginRoleInfo.setName("管理员");
        loginRoleInfo.setDescribe("123");
        loginRoleInfo.setCreatorId("system");
        loginRoleInfo.setCreateTime(1497160610259L);
        loginRoleInfo.setDeleted(0);

        LoginPermissions loginPermissions = new LoginPermissions();

        loginPermissions.setRoleId("admin");
        loginPermissions.setPermissionId("dashboard");
        loginPermissions.setPermissionName("ybp");

//        Set<LoginActionEntity> loginActionEntities = new HashSet<>();

        LoginActionEntity temp =  new LoginActionEntity();
        LoginActionEntity temp2 =  new LoginActionEntity();
        LoginActionEntity temp3 =  new LoginActionEntity();

        temp.setAction("add");
        temp.setDescribe("新增");
        temp.setDefaultCheck(false);

        loginPermissions.addLoginActionEntities(temp);

        temp2.setAction("query");
        temp2.setDescribe("查询");
        temp2.setDefaultCheck(false);

        loginPermissions.addLoginActionEntities(temp2);

//        System.out.println(loginPermissions.getActionEntitySet());

        temp3.setAction("get");
        temp3.setDescribe("详情");
        temp3.setDefaultCheck(false);

        loginPermissions.addLoginActionEntities(temp3);

//        System.out.println(loginPermissions.getActionEntitySet());




        loginPermissions.setActionList(null);
        loginPermissions.setDataAccess(null);



        loginRoleInfo.addLoginPermissions(loginPermissions);
//        System.out.println(loginRoleInfo.getLoginPermissions().getLoginActionEntities());

        userInfo.setRole(loginRoleInfo);

        System.out.println(userInfo);

//        return new ApiAntResponse<>().success(userInfo);
        return ApiDataResponse.success(userInfo);

//        return ApiDataResponse.success(testService.selectAll());
//        return
    }

    @GetMapping("/nav")
    public ApiDataResponse<Set<LoginNav>> getNav(){
        System.out.println("nav is called");
        Set<LoginNav> loginNavs = new HashSet<>();

        LoginNavMeta dashboardMeta = new LoginNavMeta();
        dashboardMeta.setTitle("menu.dashboard");
        dashboardMeta.setIcon("dashboard");
        dashboardMeta.setShow(true);

        LoginNavMeta workplaceMeta = new LoginNavMeta();
        workplaceMeta.setTitle("menu.dashboard.monitor");
        workplaceMeta.setShow(true);

// 创建 LoginNav 对象并添加到列表中
        LoginNav dashboard = new LoginNav();
        dashboard.setName("dashboard");
        dashboard.setParentId(0);
        dashboard.setId(1);
        dashboard.setMeta(dashboardMeta);
        dashboard.setComponent("RouteView");
        dashboard.setRedirect("/dashboard/workplace");
        loginNavs.add(dashboard);

        LoginNav workplace = new LoginNav();
        workplace.setName("workplace");
        workplace.setParentId(1);
        workplace.setId(7);
        workplace.setMeta(workplaceMeta);
        workplace.setComponent("Workplace");
        loginNavs.add(workplace);


        //2
        LoginNavMeta monitorMeta = new LoginNavMeta();
        monitorMeta.setTitle("menu.dashboard.workplace");
        monitorMeta.setShow(true);
        monitorMeta.setTarget("_blank"); // 设置新字段

        LoginNav monitor = new LoginNav();
        monitor.setName("monitor");
        monitor.setParentId(1);
        monitor.setId(3);
        monitor.setMeta(monitorMeta);
        monitor.setPath("https://www.baidu.com/"); // 设置新字段
        loginNavs.add(monitor);

        LoginNavMeta analysisMeta = new LoginNavMeta();
        analysisMeta.setTitle("menu.dashboard.analysis");
        analysisMeta.setShow(true);

        LoginNav analysis = new LoginNav();
        analysis.setName("Analysis");
        analysis.setParentId(1);
        analysis.setId(2);
        analysis.setMeta(analysisMeta);
        analysis.setComponent("Analysis");
        analysis.setPath("/dashboard/analysis");
        loginNavs.add(analysis);

        //form
        LoginNavMeta formMeta = new LoginNavMeta();
        formMeta.setIcon("form");
        formMeta.setTitle("menu.form");

        LoginNav form = new LoginNav();
        form.setName("form");
        form.setParentId(0);
        form.setId(10);
        form.setMeta(formMeta);
        form.setRedirect("/form/base-form");
        form.setComponent("RouteView");
        loginNavs.add(form);

        LoginNavMeta basicFormMeta = new LoginNavMeta();
        basicFormMeta.setTitle("menu.form.basic-form");

        LoginNav basicForm = new LoginNav();
        basicForm.setName("basic-form");
        basicForm.setParentId(10);
        basicForm.setId(6);
        basicForm.setMeta(basicFormMeta);
        basicForm.setComponent("BasicForm");
        loginNavs.add(basicForm);

        LoginNavMeta stepFormMeta = new LoginNavMeta();
        stepFormMeta.setTitle("menu.form.step-form");

        LoginNav stepForm = new LoginNav();
        stepForm.setName("step-form");
        stepForm.setParentId(10);
        stepForm.setId(5);
        stepForm.setMeta(stepFormMeta);
        stepForm.setComponent("StepForm");
        loginNavs.add(stepForm);

        LoginNavMeta advancedFormMeta = new LoginNavMeta();
        advancedFormMeta.setTitle("menu.form.advanced-form");

        LoginNav advancedForm = new LoginNav();
        advancedForm.setName("advanced-form");
        advancedForm.setParentId(10);
        advancedForm.setId(4);
        advancedForm.setMeta(advancedFormMeta);
        advancedForm.setComponent("AdvanceForm");
        loginNavs.add(advancedForm);

        //list
        LoginNavMeta listMeta = new LoginNavMeta();
        listMeta.setIcon("table");
        listMeta.setTitle("menu.list");
        listMeta.setShow(true);

        LoginNav list = new LoginNav();
        list.setName("list");
        list.setParentId(0);
        list.setId(10010);
        list.setMeta(listMeta);
        list.setRedirect("/list/table-list");
        list.setComponent("RouteView");
        loginNavs.add(list);

        LoginNavMeta tableListMeta = new LoginNavMeta();
        tableListMeta.setTitle("menu.list.table-list");
        tableListMeta.setShow(true);

        LoginNav tableList = new LoginNav();
        tableList.setName("table-list");
        tableList.setParentId(10010);
        tableList.setId(10011);
        tableList.setPath("/list/table-list/:pageNo([1-9]\\d*)?");
        tableList.setMeta(tableListMeta);
        tableList.setComponent("TableList");
        loginNavs.add(tableList);

        LoginNavMeta basicListMeta = new LoginNavMeta();
        basicListMeta.setTitle("menu.list.basic-list");
        basicListMeta.setShow(true);

        LoginNav basicList = new LoginNav();
        basicList.setName("basic-list");
        basicList.setParentId(10010);
        basicList.setId(10012);
        basicList.setMeta(basicListMeta);
        basicList.setComponent("StandardList");
        loginNavs.add(basicList);

// 创建 Card List 页面
        LoginNavMeta cardListMeta = new LoginNavMeta();
        cardListMeta.setTitle("menu.list.card-list");
        cardListMeta.setShow(true);

        LoginNav cardList = new LoginNav();
        cardList.setName("card");
        cardList.setParentId(10010);
        cardList.setId(10013);
        cardList.setMeta(cardListMeta);
        cardList.setComponent("CardList");
        loginNavs.add(cardList);

// 创建 Search Layout 页面
        LoginNavMeta searchLayoutMeta = new LoginNavMeta();
        searchLayoutMeta.setTitle("menu.list.search-list");
        searchLayoutMeta.setShow(true);
//        searchLayoutMeta.setRedirect("/list/search/article");

        LoginNav searchLayout = new LoginNav();
        searchLayout.setName("search");
        searchLayout.setParentId(10010);
        searchLayout.setId(10014);
        searchLayout.setMeta(searchLayoutMeta);
        searchLayout.setRedirect("/list/search/article");
        searchLayout.setComponent("SearchLayout");
        loginNavs.add(searchLayout);

// 创建 Search Articles 页面
        LoginNavMeta searchArticlesMeta = new LoginNavMeta();
        searchArticlesMeta.setTitle("menu.list.search-list.articles");
        searchArticlesMeta.setShow(true);

        LoginNav searchArticles = new LoginNav();
        searchArticles.setName("article");
        searchArticles.setParentId(10014);
        searchArticles.setId(10015);
        searchArticles.setMeta(searchArticlesMeta);
        searchArticles.setComponent("SearchArticles");
        loginNavs.add(searchArticles);

        // 创建 Search Projects 页面
        LoginNavMeta searchProjectsMeta = new LoginNavMeta();
        searchProjectsMeta.setTitle("menu.list.search-list.projects");
        searchProjectsMeta.setShow(true);

        LoginNav searchProjects = new LoginNav();
        searchProjects.setName("project");
        searchProjects.setParentId(10014);
        searchProjects.setId(10016);
        searchProjects.setMeta(searchProjectsMeta);
        searchProjects.setComponent("SearchProjects");
        loginNavs.add(searchProjects);

// 创建 Search Applications 页面
        LoginNavMeta searchApplicationsMeta = new LoginNavMeta();
        searchApplicationsMeta.setTitle("menu.list.search-list.applications");
        searchApplicationsMeta.setShow(true);

        LoginNav searchApplications = new LoginNav();
        searchApplications.setName("application");
        searchApplications.setParentId(10014);
        searchApplications.setId(10017);
        searchApplications.setMeta(searchApplicationsMeta);
        searchApplications.setComponent("SearchApplications");
        loginNavs.add(searchApplications);

        //profile
        // 创建 Profile 页面
        LoginNavMeta profileMeta = new LoginNavMeta();
        profileMeta.setTitle("menu.profile");
        profileMeta.setIcon("profile");
        profileMeta.setShow(true);

        LoginNav profile = new LoginNav();
        profile.setName("profile");
        profile.setParentId(0);
        profile.setId(10018);
        profile.setMeta(profileMeta);
        profile.setRedirect("/profile/basic");
        profile.setComponent("RouteView");
        loginNavs.add(profile);

// 创建 Profile Basic 页面
        LoginNavMeta profileBasicMeta = new LoginNavMeta();
        profileBasicMeta.setTitle("menu.profile.basic");
        profileBasicMeta.setShow(true);

        LoginNav profileBasic = new LoginNav();
        profileBasic.setName("basic");
        profileBasic.setParentId(10018);
        profileBasic.setId(10019);
        profileBasic.setMeta(profileBasicMeta);
        profileBasic.setComponent("ProfileBasic");
        loginNavs.add(profileBasic);

// 创建 Profile Advanced 页面
        LoginNavMeta profileAdvancedMeta = new LoginNavMeta();
        profileAdvancedMeta.setTitle("menu.profile.advanced");
        profileAdvancedMeta.setShow(true);

        LoginNav profileAdvanced = new LoginNav();
        profileAdvanced.setName("advanced");
        profileAdvanced.setParentId(10018);
        profileAdvanced.setId(10020);
        profileAdvanced.setMeta(profileAdvancedMeta);
        profileAdvanced.setComponent("ProfileAdvanced");
        loginNavs.add(profileAdvanced);

        //result
        // 创建 Result 页面
        LoginNavMeta resultMeta = new LoginNavMeta();
        resultMeta.setTitle("menu.result");
        resultMeta.setIcon("check-circle-o");
        resultMeta.setShow(true);

        LoginNav result = new LoginNav();
        result.setName("result");
        result.setParentId(0);
        result.setId(10021);
        result.setMeta(resultMeta);
        result.setRedirect("/result/success");
        result.setComponent("PageView");
        loginNavs.add(result);

// 创建 Result Success 页面
        LoginNavMeta resultSuccessMeta = new LoginNavMeta();
        resultSuccessMeta.setTitle("menu.result.success");
        resultSuccessMeta.setHiddenHeaderContent(true);
        resultSuccessMeta.setShow(true);

        LoginNav resultSuccess = new LoginNav();
        resultSuccess.setName("success");
        resultSuccess.setParentId(10021);
        resultSuccess.setId(10022);
        resultSuccess.setMeta(resultSuccessMeta);
        resultSuccess.setComponent("ResultSuccess");
        loginNavs.add(resultSuccess);

// 创建 Result Fail 页面
        LoginNavMeta resultFailMeta = new LoginNavMeta();
        resultFailMeta.setTitle("menu.result.fail");
        resultFailMeta.setHiddenHeaderContent(true);
        resultFailMeta.setShow(true);

        LoginNav resultFail = new LoginNav();
        resultFail.setName("fail");
        resultFail.setParentId(10021);
        resultFail.setId(10023);
        resultFail.setMeta(resultFailMeta);
        resultFail.setComponent("ResultFail");
        loginNavs.add(resultFail);

        //exception
        // 创建 Exception 页面
        LoginNavMeta exceptionMeta = new LoginNavMeta();
        exceptionMeta.setTitle("menu.exception");
        exceptionMeta.setIcon("warning");
        exceptionMeta.setShow(true);

        LoginNav exception = new LoginNav();
        exception.setName("exception");
        exception.setParentId(0);
        exception.setId(10024);
        exception.setMeta(exceptionMeta);
        exception.setRedirect("/exception/403");
        exception.setComponent("RouteView");
        loginNavs.add(exception);

// 创建 403 页面
        LoginNavMeta exception403Meta = new LoginNavMeta();
        exception403Meta.setTitle("menu.exception.not-permission");
        exception403Meta.setShow(true);

        LoginNav exception403 = new LoginNav();
        exception403.setName("403");
        exception403.setParentId(10024);
        exception403.setId(10025);
        exception403.setMeta(exception403Meta);
        exception403.setComponent("Exception403");
        loginNavs.add(exception403);

// 创建 404 页面
        LoginNavMeta exception404Meta = new LoginNavMeta();
        exception404Meta.setTitle("menu.exception.not-find");
        exception404Meta.setShow(true);

        LoginNav exception404 = new LoginNav();
        exception404.setName("404");
        exception404.setParentId(10024);
        exception404.setId(10026);
        exception404.setMeta(exception404Meta);
        exception404.setComponent("Exception404");
        loginNavs.add(exception404);

// 创建 500 页面
        LoginNavMeta exception500Meta = new LoginNavMeta();
        exception500Meta.setTitle("menu.exception.server-error");
        exception500Meta.setShow(true);

        LoginNav exception500 = new LoginNav();
        exception500.setName("500");
        exception500.setParentId(10024);
        exception500.setId(10027);
        exception500.setMeta(exception500Meta);
        exception500.setComponent("Exception500");
        loginNavs.add(exception500);

        //account
        // 创建 Account 页面
        LoginNavMeta accountMeta = new LoginNavMeta();
        accountMeta.setTitle("menu.account");
        accountMeta.setIcon("user");
        accountMeta.setShow(true);

        LoginNav account = new LoginNav();
        account.setName("account");
        account.setParentId(0);
        account.setId(10028);
        account.setMeta(accountMeta);
        account.setRedirect("/account/center");
        account.setComponent("RouteView");
        loginNavs.add(account);

// 创建 Center 页面
        LoginNavMeta centerMeta = new LoginNavMeta();
        centerMeta.setTitle("menu.account.center");
        centerMeta.setShow(true);

        LoginNav center = new LoginNav();
        center.setName("center");
        center.setParentId(10028);
        center.setId(10029);
        center.setMeta(centerMeta);
        center.setComponent("AccountCenter");
        loginNavs.add(center);

// 创建 Settings 页面
        LoginNavMeta settingsMeta = new LoginNavMeta();
        settingsMeta.setTitle("menu.account.settings");
        settingsMeta.setHideHeader(true);
        settingsMeta.setHideChildren(true);
        settingsMeta.setShow(true);

        LoginNav settings = new LoginNav();
        settings.setName("settings");
        settings.setParentId(10028);
        settings.setId(10030);
        settings.setMeta(settingsMeta);
        settings.setRedirect("/account/settings/basic");
        settings.setComponent("AccountSettings");
        loginNavs.add(settings);

// 创建 BasicSettings 页面
        LoginNavMeta basicSettingsMeta = new LoginNavMeta();
        basicSettingsMeta.setTitle("account.settings.menuMap.basic");
        basicSettingsMeta.setShow(false);

        LoginNav basicSettings = new LoginNav();
        basicSettings.setName("BasicSettings");
        basicSettings.setPath("/account/settings/basic");
        basicSettings.setParentId(10030);
        basicSettings.setId(10031);
        basicSettings.setMeta(basicSettingsMeta);
        basicSettings.setComponent("BasicSetting");
        loginNavs.add(basicSettings);

// 创建 SecuritySettings 页面
        LoginNavMeta securitySettingsMeta = new LoginNavMeta();
        securitySettingsMeta.setTitle("account.settings.menuMap.security");
        securitySettingsMeta.setShow(false);

        LoginNav securitySettings = new LoginNav();
        securitySettings.setName("SecuritySettings");
        securitySettings.setPath("/account/settings/security");
        securitySettings.setParentId(10030);
        securitySettings.setId(10032);
        securitySettings.setMeta(securitySettingsMeta);
        securitySettings.setComponent("SecuritySettings");
        loginNavs.add(securitySettings);

// 创建 CustomSettings 页面
        LoginNavMeta customSettingsMeta = new LoginNavMeta();
        customSettingsMeta.setTitle("account.settings.menuMap.custom");
        customSettingsMeta.setShow(false);

        LoginNav customSettings = new LoginNav();
        customSettings.setName("CustomSettings");
        customSettings.setPath("/account/settings/custom");
        customSettings.setParentId(10030);
        customSettings.setId(10033);
        customSettings.setMeta(customSettingsMeta);
        customSettings.setComponent("CustomSettings");
        loginNavs.add(customSettings);

// 创建 BindingSettings 页面
        LoginNavMeta bindingSettingsMeta = new LoginNavMeta();
        bindingSettingsMeta.setTitle("account.settings.menuMap.binding");
        bindingSettingsMeta.setShow(false);

        LoginNav bindingSettings = new LoginNav();
        bindingSettings.setName("BindingSettings");
        bindingSettings.setPath("/account/settings/binding");
        bindingSettings.setParentId(10030);
        bindingSettings.setId(10034);
        bindingSettings.setMeta(bindingSettingsMeta);
        bindingSettings.setComponent("BindingSettings");
        loginNavs.add(bindingSettings);

// 创建 NotificationSettings 页面
        LoginNavMeta notificationSettingsMeta = new LoginNavMeta();
        notificationSettingsMeta.setTitle("account.settings.menuMap.notification");
        notificationSettingsMeta.setShow(false);

        LoginNav notificationSettings = new LoginNav();
        notificationSettings.setName("NotificationSettings");
        notificationSettings.setPath("/account/settings/notification");
        notificationSettings.setParentId(10030);
        notificationSettings.setId(10035);
        notificationSettings.setMeta(notificationSettingsMeta);
        notificationSettings.setComponent("NotificationSettings");
        loginNavs.add(notificationSettings);



        return ApiDataResponse.success(loginNavs);
    }
}
