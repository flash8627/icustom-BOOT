
SELECT gh.forecast_header_id      forecastheaderid,
       gh.pdt_type                pdttype,
       gh.pdt_id                  pdtid,
       gh.supply_entity_id        supplyentityid,
       gh.bucket_dimension        bucketdimension,
       gh.forecast_dimension_code forecastdimensioncode,
       gh.forecast_status         forecaststatus,
       gh.delete_flag             deleteflag,
       gh.created_by              createdby,
       gh.created_name            creationusercn,
       gh.creation_date           creationdate,
       gh.last_updated_by         lastupdatedby,
       gh.last_updated_name       lastupdateusercn,
       gh.last_update_date        lastupdatedate,
       
       pd.pdt_large_code    pdtlargecode,
       pd.pdt_large_name_cn pdtlargenamecn,
       pd.pdt_large_name_en pdtlargenameen,
       pd.pdt_large_uom     pdtlargeuom,
       
       fd.forecast_dimension_desc_cn  forecastdimensiondesccn,
       fd.forecast_dimension_desc_en  forecastdimensiondescen,
       fd.forecast_dimension_category forecastdimensioncategory,
       fd.edit_flag                   editflag,
       fd.rate_flag                   rateflag,
       
       /*(SELECT t.area_org_name_cn
       FROM dsf_area_org_t t
       INNER JOIN dsf_demand_entity_t pt
       ON (t.area_org_code = pt.demand_entity_code AND
       upper(t.area_org_type) = upper(pt.demand_entity_type) AND
       t.enable_flag = 'Y' AND pt.enable_flag = 'Y')
       AND pt.demand_entity_id = de.demand_entity_id
       AND rownum = 1) areaorgname,*/
       
       (select area_org_name_cn
          from (SELECT t.area_org_name_cn, pt.demand_entity_id
                  FROM dsf_area_org_t t, dsf_demand_entity_t pt
                 WHERE t.area_org_code = pt.demand_entity_code
                   AND upper(t.area_org_type) = upper(pt.demand_entity_type)
                   AND t.enable_flag = 'Y'
                   AND pt.enable_flag = 'Y') aa
         where aa.demand_entity_id = de.demand_entity_id) areaorgname,
       
       de.demand_entity_id   demandentityid,
       de.bg_code            bgcode,
       de.demand_entity_type demandentitytype,
       de.demand_entity_code demandentitycode,
       
       po.lv0_org_code    lv0orgcode,
       po.lv0_type_name   lv0typename,
       po.lv0_org_name_cn lv0orgnamecn,
       po.lv0_org_name_en lv0orgnameen,
       
       po.lv1_org_code    lv1orgcode,
       po.lv1_type_name   lv1typename,
       po.lv1_org_name_cn lv1orgnamecn,
       po.lv1_org_name_en lv1orgnameen,
       
       po.lv2_org_code    lv2orgcode,
       po.lv2_type_name   lv2typename,
       po.lv2_org_name_cn lv2orgnamecn,
       po.lv2_org_name_en lv2orgnameen,
       
       po.lv3_org_code    lv3orgcode,
       po.lv3_type_name   lv3typename,
       po.lv3_org_name_cn lv3orgnamecn,
       po.lv3_org_name_en lv3orgnameen,
       
       po.lv4_org_code    lv4orgcode,
       po.lv4_type_name   lv4typename,
       po.lv4_org_name_cn lv4orgnamecn,
       po.lv4_org_name_en lv4orgnameen

  FROM dsf_forecast_region_header_t gh

  LEFT JOIN dsf_demand_entity_t de
    ON (gh.demand_entity_id = de.demand_entity_id AND de.enable_flag = 'Y')
    
  LEFT JOIN dsf_area_org_t ao
    ON (ao.area_org_code = de.demand_entity_code AND
       ao.area_org_type = 'REGION')

  LEFT JOIN dsf_pdt_large_t pd
    ON (pd.pdt_large_id = gh.pdt_id AND pd.enable_flag = 'Y')

  LEFT JOIN dsf_pdt_org_t po
    ON (po.pdt_org_id = pd.pdt_org_id AND po.enable_flag = 'Y')

  LEFT JOIN dsf_forecast_dimension_t fd
    ON (fd.forecast_dimension_code = gh.forecast_dimension_code AND
       fd.bg_code = '01' AND
       upper(fd.demand_entity_type) = upper('region') AND
       fd.bucket_dimension = 'Y')
