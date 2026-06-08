import {Card, CardTitle, CardContent, CardHeader} from "@/components/ui/card";
import {useQuery} from "@tanstack/react-query";
import {ButtonGroup} from "@/components/ui/button-group";
import {Button} from "@/components/ui/button";
import {Clock9, PhoneCall} from "lucide-react";
import {Link} from "react-router-dom";

const SearchList = () => {
    const {data, isLoading} = useQuery({
        queryKey: ['search'],
        queryFn: () => {
            // const [params] = useSearchParams();
            // console.log("expert name", params.get("expert") || "all");
            // console.log("field", params.get("field") || "all");
            const timer = setTimeout(() => {

            }, 5000);
            clearTimeout(timer)
            return [
                {
                    id: 1234, title: "title1", description: "desc1", content: "lorem ipsimel lka d lkjasd ."
                },
                {
                    id: 5678,
                    title: "title2",
                    description: "desc2",
                    content: "lorem ipsimel lka d lkjas2 2  sdjkfh jkdshf kjdshf kjdhs fkjhd skjfh sdkjhf ksdjhf kjsdhf kjsdhf kjsdhf kjsdhf kjsdh dsflk dsfk dskjfh dskjhf kjh2 d ."
                }
            ];
        }
    })
    console.log(data);
    return (
        <section className="container mx-auto mt-16 ">
            <h1 className="mb-8 font-bold text-2xl">
                Search list
            </h1>
            {isLoading ? "loading ..." : (
                <ul role="list" className="divide-y space-y-2">
                    {!isLoading && data!.map((item, index) =>
                        (
                            <li key={index}
                                className="flex justify-between gap-1 hover:bg-accent border cursor-pointer">
                                <Card key={index} size="sm" className="min-w-7/8 bg-transparent border-0 ring-0">
                                    <CardHeader>
                                        <CardTitle>{item.title} | developer</CardTitle>
                                    </CardHeader>
                                    <CardContent className="truncate">
                                        {item.content}
                                    </CardContent>
                                </Card>
                                <ButtonGroup orientation="vertical"
                                             className="min-w-1/8 gap-0 space-x-0 justify-between">
                                    <Button asChild size="lg" variant="default"
                                            className="flex-1 text-base cursor-pointer">
                                        <Link to={`/book/${item.id}`}>
                                            <Clock9 className="hidden lg:block size-6"/> Book
                                        </Link>
                                    </Button>
                                    <Button size="lg" variant="default"
                                            className="flex-1 text-base cursor-pointer bg-green-600 hover:bg-green-700">
                                        <PhoneCall className="hidden lg:block size-6"/> Call
                                    </Button>
                                </ButtonGroup>
                            </li>
                        )
                    )}
                </ul>
            )}
        </section>
    );
}

export default SearchList;