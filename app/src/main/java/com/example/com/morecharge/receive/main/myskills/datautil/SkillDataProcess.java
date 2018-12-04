package com.example.com.morecharge.receive.main.myskills.datautil;

import com.example.com.morecharge.receive.main.myskills.entity.SkillsResponseEntry;

import java.util.ArrayList;
import java.util.List;

public class SkillDataProcess {

    public static List<SkillsResponseEntry.DataBean> filterUserOwnSkills(List<SkillsResponseEntry.DataBean> skillData) {

        List<SkillsResponseEntry.DataBean> havaSkills = new ArrayList<>();

        if (skillData != null) {

            for (int i = 0; i < skillData.size(); i++) {

                SkillsResponseEntry.DataBean dataBean = skillData.get(i);

                List<SkillsResponseEntry.DataBean.GroupValBean> groupVal = dataBean.getGroupVal();

                List<SkillsResponseEntry.DataBean.GroupValBean> haveSkillChild = new ArrayList<>();

                SkillsResponseEntry.DataBean itemDataBean = new SkillsResponseEntry.DataBean();
                for (int j = 0; j < groupVal.size(); j++) {

                    SkillsResponseEntry.DataBean.GroupValBean groupValBean = groupVal.get(j);

                    String isHave = groupValBean.getIsHave();

                    if ("Y".equalsIgnoreCase(isHave)) {

                        itemDataBean.setGroupName(dataBean.getGroupName());

                        haveSkillChild.add(groupValBean);

                    }

                }

                if (haveSkillChild.size() > 0) {
                    itemDataBean.setGroupVal(haveSkillChild);

                    havaSkills.add(itemDataBean);
                }

            }

            return havaSkills;
        } else {
            return new ArrayList<>();
        }

    }

}


