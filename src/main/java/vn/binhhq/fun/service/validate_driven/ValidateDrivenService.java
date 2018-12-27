package vn.binhhq.fun.service.validate_driven;

import javafx.util.Pair;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import vn.binhhq.fun.service.validate_driven.inout.MethodData;
import vn.binhhq.fun.service.validate_driven.inout.ProductData;
import vn.binhhq.fun.service.validate_driven.inout.UpdateDrivenReq;

import java.util.*;

@Service
@Log4j2
public class ValidateDrivenService {

    public boolean validate(List<UpdateDrivenReq> reqs){
        System.out.println("Req" + reqs);

        // only validate active data
        Map<Long, List<Long>> methodChannels = getMethodChannelActive(reqs);
        System.out.println("Method channels : " + methodChannels);

        List<Pair<Long, Long>> channelProducts = getChannelProductActive(reqs);
        System.out.println("Channel Products : " + channelProducts);

        List<List<Long>> groupChannels = getGroupChannelHasSameProduct(channelProducts);
        System.out.println("Group channels :" + groupChannels);

        boolean result = validateActivedChannelMethod(groupChannels, methodChannels);
        System.out.println("Result :" + result);
        return result;
    }

    /**
     * get pair channel product active
     * @param reqs
     * @return
     */
    private List<Pair<Long, Long>> getChannelProductActive(List<UpdateDrivenReq> reqs){
        List<Pair<Long, Long>> activedChannelProducts = new ArrayList<>();
        for(UpdateDrivenReq req : reqs){
            long channelId = req.getChannelId();
            List<ProductData> products = req.getProducts();
            for (ProductData product : products){
                if(product.getStatus().equals("ACTIVE")){
                    Pair pair = new Pair(channelId, product.getProductId());
                    if(!activedChannelProducts.contains(pair)){
                        activedChannelProducts.add(pair);
                    }

                }
            }
        }
        return activedChannelProducts;
    }

    /**
     * get pair channel method active
     * @param reqs
     * @return
     */
    private Map<Long, List<Long>> getMethodChannelActive(List<UpdateDrivenReq> reqs){
        Map<Long, List<Long>> result = new HashMap<Long, List<Long>>();
        // loop through requests
        for(UpdateDrivenReq req : reqs){
            long channelId = req.getChannelId();
            List<MethodData> methods = req.getMethods();

            // loop through methods
            for(MethodData method : methods){

                if(method.getStatus().equals("ACTIVE")){
                    long methodId = method.getMethodId();
                    // if status = active add channelId to list
                    if(result.get(methodId) == null){
                        List<Long> channels = new ArrayList<Long>();
                        channels.add(channelId);
                        result.put(methodId, channels);
                    } else{
                        result.get(methodId).add(channelId);
                    }
                }
            }
        }
        return result;
    }

    /**
     * get group channel has same product active
     * @param channelProducts
     * @return
     */
    private List<List<Long>> getGroupChannelHasSameProduct(List<Pair<Long, Long>> channelProducts){
        List<Long> alreadyCheckedProductIds = new ArrayList<Long>();
        List<List<Long>> channelsList = new ArrayList<>();
        for (Pair<Long, Long> channelProduct1 : channelProducts){

            long channelId1 = channelProduct1.getKey();
            long productId1 = channelProduct1.getValue();
            // ignore if already check
            if(!alreadyCheckedProductIds.contains(productId1)){
                List<Long> channels = new ArrayList<Long>();

                for (Pair<Long, Long> channelProduct2 : channelProducts){

                    long channelId2 = channelProduct2.getKey();
                    long productId2 = channelProduct2.getValue();

                    // diff channel same product
                    if(channelId1 != channelId2 && productId1 == productId2){
                        alreadyCheckedProductIds.add(productId1);
                        if(!channels.contains(channelId1)){
                            channels.add(channelId1);
                        }
                        if(!channels.contains(channelId2)){
                            channels.add(channelId2);
                        }
                    }
                }

                if(channels.size() > 0){
                    channelsList.add(channels);
                }
                alreadyCheckedProductIds.contains(productId1);
            }

        }
        return channelsList;
    }

    private boolean validateActivedChannelMethod(List<List<Long>> groupChannelList, Map<Long, List<Long>> activedMethodChannels){
        if(groupChannelList.size() == 0)
            return true;

        for (Map.Entry<Long, List<Long>> entry : activedMethodChannels.entrySet())
        {
            long methodId = entry.getKey();
            List<Long> channelInMethods = entry.getValue();
            for (List<Long> groupChannel : groupChannelList ){
                if(channelInMethods.containsAll(groupChannel)){
                    return false;
                }
            }
        }
        return true;
    }
}
